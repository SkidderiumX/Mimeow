/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_11_1to1_12;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_12;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_9_3;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.data.ChatItemRewriter;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.data.TranslateRewriter;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.packet.ClientboundPackets1_12;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.packet.ServerboundPackets1_12;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.provider.InventoryQuickMoveProvider;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.rewriter.EntityPacketRewriter1_12;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.rewriter.ItemPacketRewriter1_12;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ServerboundPackets1_9_3;

public class Protocol1_11_1To1_12
extends AbstractProtocol<ClientboundPackets1_9_3, ClientboundPackets1_12, ServerboundPackets1_9_3, ServerboundPackets1_12> {
    private final EntityPacketRewriter1_12 entityRewriter = new EntityPacketRewriter1_12(this);
    private final ItemPacketRewriter1_12 itemRewriter = new ItemPacketRewriter1_12(this);

    public Protocol1_11_1To1_12() {
        super(ClientboundPackets1_9_3.class, ClientboundPackets1_12.class, ServerboundPackets1_9_3.class, ServerboundPackets1_12.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.registerClientbound(ClientboundPackets1_9_3.SOUND, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            int n2 = this.getNewSoundId(n);
            if (n2 == -1) {
                packetWrapper.cancel();
            } else {
                packetWrapper.write(Types.VAR_INT, n2);
            }
        });
        this.registerClientbound(ClientboundPackets1_9_3.CHAT, packetWrapper -> {
            JsonElement jsonElement = packetWrapper.passthrough(Types.COMPONENT);
            TranslateRewriter.toClient(packetWrapper.user(), jsonElement);
            ChatItemRewriter.toClient(jsonElement);
            packetWrapper.set(Types.COMPONENT, 0, jsonElement);
        });
        this.registerClientbound(ClientboundPackets1_9_3.LEVEL_CHUNK, packetWrapper -> {
            Object t = packetWrapper.user().getClientWorld(Protocol1_11_1To1_12.class);
            ChunkType1_9_3 chunkType1_9_3 = ChunkType1_9_3.forEnvironment(((ClientWorld)t).getEnvironment());
            Chunk chunk = packetWrapper.passthrough(chunkType1_9_3);
            for (int i = 0; i < chunk.getSections().length; ++i) {
                ChunkSection chunkSection = chunk.getSections()[i];
                if (chunkSection == null) continue;
                DataPalette dataPalette = chunkSection.palette(PaletteType.BLOCKS);
                for (int j = 0; j < 4096; ++j) {
                    int n = dataPalette.idAt(j) >> 4;
                    if (n != 26) continue;
                    CompoundTag compoundTag = new CompoundTag();
                    compoundTag.put("color", new IntTag(14));
                    compoundTag.put("x", new IntTag(ChunkSection.xFromIndex(j) + (chunk.getX() << 4)));
                    compoundTag.put("y", new IntTag(ChunkSection.yFromIndex(j) + (i << 4)));
                    compoundTag.put("z", new IntTag(ChunkSection.zFromIndex(j) + (chunk.getZ() << 4)));
                    compoundTag.put("id", new StringTag("minecraft:bed"));
                    chunk.getBlockEntities().add(compoundTag);
                }
            }
        });
        this.cancelServerbound(ServerboundPackets1_12.CRAFTING_RECIPE_PLACEMENT);
        this.registerServerbound(ServerboundPackets1_12.CLIENT_INFORMATION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    String string = packetWrapper.get(Types.STRING, 0);
                    if (string.length() > 7) {
                        packetWrapper.set(Types.STRING, 0, string.substring(0, 7));
                    }
                });
            }
        });
        this.cancelServerbound(ServerboundPackets1_12.RECIPE_BOOK_UPDATE);
        this.cancelServerbound(ServerboundPackets1_12.SEEN_ADVANCEMENTS);
    }

    private int getNewSoundId(int n) {
        int n2 = n;
        if (n >= 26) {
            n2 += 2;
        }
        if (n >= 70) {
            n2 += 4;
        }
        if (n >= 74) {
            ++n2;
        }
        if (n >= 143) {
            n2 += 3;
        }
        if (n >= 185) {
            ++n2;
        }
        if (n >= 263) {
            n2 += 7;
        }
        if (n >= 301) {
            n2 += 33;
        }
        if (n >= 317) {
            n2 += 2;
        }
        if (n >= 491) {
            n2 += 3;
        }
        return n2;
    }

    @Override
    public void register(ViaProviders viaProviders) {
        viaProviders.register(InventoryQuickMoveProvider.class, new InventoryQuickMoveProvider());
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addEntityTracker(this.getClass(), new EntityTrackerBase(userConnection, EntityTypes1_12.EntityType.PLAYER));
        userConnection.addClientWorld(this.getClass(), new ClientWorld());
    }

    public EntityPacketRewriter1_12 getEntityRewriter() {
        return this.entityRewriter;
    }

    public ItemPacketRewriter1_12 getItemRewriter() {
        return this.itemRewriter;
    }
}


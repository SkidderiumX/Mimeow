/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_9_1to1_9_3;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_9_1;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_9_3;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.data.FakeTileEntities1_9_1;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ServerboundPackets1_9_3;
import java.util.List;

public class Protocol1_9_1To1_9_3
extends AbstractProtocol<ClientboundPackets1_9, ClientboundPackets1_9_3, ServerboundPackets1_9, ServerboundPackets1_9_3> {
    public static final ValueTransformer<Short, Short> ADJUST_PITCH = new ValueTransformer<Short, Short>((Type)Types.UNSIGNED_BYTE, (Type)Types.UNSIGNED_BYTE){

        @Override
        public Short transform(PacketWrapper packetWrapper, Short s) {
            return (short)Math.round((float)s.shortValue() / 63.5f * 63.0f);
        }
    };

    public Protocol1_9_1To1_9_3() {
        super(ClientboundPackets1_9.class, ClientboundPackets1_9_3.class, ServerboundPackets1_9.class, ServerboundPackets1_9_3.class);
    }

    @Override
    protected void registerPackets() {
        this.registerClientbound(ClientboundPackets1_9.UPDATE_SIGN, null, (PacketWrapper packetWrapper) -> {
            BlockPosition blockPosition = packetWrapper.read(Types.BLOCK_POSITION1_8);
            JsonElement[] jsonElementArray = new JsonElement[4];
            for (int i = 0; i < 4; ++i) {
                jsonElementArray[i] = packetWrapper.read(Types.COMPONENT);
            }
            packetWrapper.clearInputBuffer();
            packetWrapper.setPacketType(ClientboundPackets1_9_3.BLOCK_ENTITY_DATA);
            packetWrapper.write(Types.BLOCK_POSITION1_8, blockPosition);
            packetWrapper.write(Types.UNSIGNED_BYTE, (short)9);
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.put("id", new StringTag("Sign"));
            compoundTag.put("x", new IntTag(blockPosition.x()));
            compoundTag.put("y", new IntTag(blockPosition.y()));
            compoundTag.put("z", new IntTag(blockPosition.z()));
            for (int i = 0; i < jsonElementArray.length; ++i) {
                compoundTag.put("Text" + (i + 1), new StringTag(jsonElementArray[i].toString()));
            }
            packetWrapper.write(Types.NAMED_COMPOUND_TAG, compoundTag);
        });
        this.registerClientbound(ClientboundPackets1_9.LEVEL_CHUNK, packetWrapper -> {
            Object t = packetWrapper.user().getClientWorld(Protocol1_9_1To1_9_3.class);
            Chunk chunk = packetWrapper.read(ChunkType1_9_1.forEnvironment(((ClientWorld)t).getEnvironment()));
            packetWrapper.write(ChunkType1_9_3.forEnvironment(((ClientWorld)t).getEnvironment()), chunk);
            List<CompoundTag> list = chunk.getBlockEntities();
            for (int i = 0; i < chunk.getSections().length; ++i) {
                ChunkSection chunkSection = chunk.getSections()[i];
                if (chunkSection == null) continue;
                DataPalette dataPalette = chunkSection.palette(PaletteType.BLOCKS);
                int n3 = i;
                dataPalette.forEachMatchingCoordinate(n -> FakeTileEntities1_9_1.isTileEntity(n >> 4), n2 -> list.add(FakeTileEntities1_9_1.createTileEntity(ChunkSection.xFromIndex(n2) + (chunk.getX() << 4), ChunkSection.yFromIndex(n2) + (n3 << 4), ChunkSection.zFromIndex(n2) + (chunk.getZ() << 4), dataPalette.idAt(n2) >> 4)));
            }
        });
        this.registerClientbound(ClientboundPackets1_9.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    Object t = packetWrapper.user().getClientWorld(Protocol1_9_1To1_9_3.class);
                    int n = packetWrapper.get(Types.INT, 1);
                    ((ClientWorld)t).setEnvironment(n);
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_9.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    Object t = packetWrapper.user().getClientWorld(Protocol1_9_1To1_9_3.class);
                    int n = packetWrapper.get(Types.INT, 0);
                    ((ClientWorld)t).setEnvironment(n);
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_9.SOUND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.FLOAT);
                this.map(ADJUST_PITCH);
            }
        });
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addClientWorld(this.getClass(), new ClientWorld());
    }
}


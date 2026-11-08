/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_9_3to1_10;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_9;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_9_3;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ServerboundPackets1_9_3;
import com.viaversion.viaversion.protocols.v1_9_3to1_10.rewriter.EntityPacketRewriter1_10;
import com.viaversion.viaversion.protocols.v1_9_3to1_10.rewriter.ItemPacketRewriter1_10;
import com.viaversion.viaversion.protocols.v1_9_3to1_10.storage.ResourcePackTracker;

public class Protocol1_9_3To1_10
extends AbstractProtocol<ClientboundPackets1_9_3, ClientboundPackets1_9_3, ServerboundPackets1_9_3, ServerboundPackets1_9_3> {
    public static final ValueTransformer<Short, Float> TO_NEW_PITCH = new ValueTransformer<Short, Float>((Type)Types.FLOAT){

        @Override
        public Float transform(PacketWrapper packetWrapper, Short s) {
            return Float.valueOf((float)s.shortValue() / 63.0f);
        }
    };
    private final EntityPacketRewriter1_10 entityRewriter = new EntityPacketRewriter1_10(this);
    private final ItemPacketRewriter1_10 itemRewriter = new ItemPacketRewriter1_10(this);

    public Protocol1_9_3To1_10() {
        super(ClientboundPackets1_9_3.class, ClientboundPackets1_9_3.class, ServerboundPackets1_9_3.class, ServerboundPackets1_9_3.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.registerClientbound(ClientboundPackets1_9_3.CUSTOM_SOUND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.VAR_INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.FLOAT);
                this.map(Types.UNSIGNED_BYTE, TO_NEW_PITCH);
            }
        });
        this.registerClientbound(ClientboundPackets1_9_3.SOUND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.FLOAT);
                this.map(Types.UNSIGNED_BYTE, TO_NEW_PITCH);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    packetWrapper.set(Types.VAR_INT, 0, Protocol1_9_3To1_10.this.getNewSoundId(n));
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_9_3.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    Object t = packetWrapper.user().getClientWorld(Protocol1_9_3To1_10.class);
                    int n = packetWrapper.get(Types.INT, 1);
                    ((ClientWorld)t).setEnvironment(n);
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_9_3.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    Object t = packetWrapper.user().getClientWorld(Protocol1_9_3To1_10.class);
                    int n = packetWrapper.get(Types.INT, 0);
                    ((ClientWorld)t).setEnvironment(n);
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_9_3.LEVEL_CHUNK, packetWrapper -> {
            Object t = packetWrapper.user().getClientWorld(Protocol1_9_3To1_10.class);
            Chunk chunk = packetWrapper.passthrough(ChunkType1_9_3.forEnvironment(((ClientWorld)t).getEnvironment()));
            if (Via.getConfig().isReplacePistons()) {
                int n = Via.getConfig().getPistonReplacementId();
                for (ChunkSection chunkSection : chunk.getSections()) {
                    if (chunkSection == null) continue;
                    chunkSection.palette(PaletteType.BLOCKS).replaceId(36, n);
                }
            }
        });
        this.registerClientbound(ClientboundPackets1_9_3.RESOURCE_PACK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    ResourcePackTracker resourcePackTracker = packetWrapper.user().get(ResourcePackTracker.class);
                    resourcePackTracker.setLastHash(packetWrapper.get(Types.STRING, 1));
                });
            }
        });
        this.registerServerbound(ServerboundPackets1_9_3.RESOURCE_PACK, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    ResourcePackTracker resourcePackTracker = packetWrapper.user().get(ResourcePackTracker.class);
                    packetWrapper.write(Types.STRING, resourcePackTracker.getLastHash());
                    packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.VAR_INT));
                });
            }
        });
    }

    public int getNewSoundId(int n) {
        int n2 = n;
        if (n >= 24) {
            ++n2;
        }
        if (n >= 248) {
            n2 += 4;
        }
        if (n >= 296) {
            n2 += 6;
        }
        if (n >= 354) {
            n2 += 4;
        }
        if (n >= 372) {
            n2 += 4;
        }
        return n2;
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_9.EntityType.PLAYER));
        userConnection.addClientWorld(this.getClass(), new ClientWorld());
        userConnection.put(new ResourcePackTracker());
    }

    public ItemPacketRewriter1_10 getItemRewriter() {
        return this.itemRewriter;
    }

    public EntityPacketRewriter1_10 getEntityRewriter() {
        return this.entityRewriter;
    }
}


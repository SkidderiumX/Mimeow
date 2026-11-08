/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_10to1_11;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_9_3;
import com.viaversion.viaversion.protocols.v1_10to1_11.data.BlockEntityMappings1_11;
import com.viaversion.viaversion.protocols.v1_10to1_11.data.EntityMappings1_11;
import com.viaversion.viaversion.protocols.v1_10to1_11.data.PotionColorMappings1_11;
import com.viaversion.viaversion.protocols.v1_10to1_11.rewriter.EntityPacketRewriter1_11;
import com.viaversion.viaversion.protocols.v1_10to1_11.rewriter.ItemPacketRewriter1_11;
import com.viaversion.viaversion.protocols.v1_10to1_11.storage.EntityTracker1_11;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ServerboundPackets1_9_3;

public class Protocol1_10To1_11
extends AbstractProtocol<ClientboundPackets1_9_3, ClientboundPackets1_9_3, ServerboundPackets1_9_3, ServerboundPackets1_9_3> {
    private static final ValueTransformer<Float, Short> toOldByte = new ValueTransformer<Float, Short>((Type)Types.UNSIGNED_BYTE){

        @Override
        public Short transform(PacketWrapper packetWrapper, Float f) {
            return (short)(f.floatValue() * 16.0f);
        }
    };
    private final EntityPacketRewriter1_11 entityRewriter = new EntityPacketRewriter1_11(this);
    private final ItemPacketRewriter1_11 itemRewriter = new ItemPacketRewriter1_11(this);

    public Protocol1_10To1_11() {
        super(ClientboundPackets1_9_3.class, ClientboundPackets1_9_3.class, ServerboundPackets1_9_3.class, ServerboundPackets1_9_3.class);
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
        this.registerClientbound(ClientboundPackets1_9_3.SET_TITLES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (n >= 2) {
                        packetWrapper.set(Types.VAR_INT, 0, n + 1);
                    }
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_9_3.BLOCK_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n;
                    if (Via.getConfig().isPistonAnimationPatch() && ((n = packetWrapper.get(Types.VAR_INT, 0).intValue()) == 33 || n == 29)) {
                        packetWrapper.cancel();
                    }
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_9_3.LEVEL_CHUNK, packetWrapper -> {
            Object t = packetWrapper.user().getClientWorld(Protocol1_10To1_11.class);
            Chunk chunk = packetWrapper.passthrough(ChunkType1_9_3.forEnvironment(((ClientWorld)t).getEnvironment()));
            if (chunk.getBlockEntities() == null) {
                return;
            }
            for (CompoundTag compoundTag : chunk.getBlockEntities()) {
                StringTag stringTag = compoundTag.getStringTag("id");
                if (stringTag == null) continue;
                String string = stringTag.getValue();
                if (string.equals("MobSpawner")) {
                    EntityMappings1_11.toClientSpawner(compoundTag);
                }
                stringTag.setValue(BlockEntityMappings1_11.toNewIdentifier(string));
            }
        });
        this.registerClientbound(ClientboundPackets1_9_3.LEVEL_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    if (n == 2002) {
                        int n2 = packetWrapper.get(Types.INT, 1);
                        boolean bl = false;
                        PotionColorMappings1_11.PotionData potionData = PotionColorMappings1_11.getNewData(n2);
                        if (potionData == null) {
                            Protocol1_10To1_11.this.getLogger().warning("Received unknown potion data: " + n2);
                            n2 = 0;
                        } else {
                            n2 = potionData.data();
                            bl = potionData.instant();
                        }
                        if (bl) {
                            packetWrapper.set(Types.INT, 0, 2007);
                        }
                        packetWrapper.set(Types.INT, 1, n2);
                    }
                });
            }
        });
        this.registerServerbound(ServerboundPackets1_9_3.USE_ITEM_ON, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.FLOAT, toOldByte);
                this.map(Types.FLOAT, toOldByte);
                this.map(Types.FLOAT, toOldByte);
            }
        });
        this.registerServerbound(ServerboundPackets1_9_3.CHAT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    String string = packetWrapper.get(Types.STRING, 0);
                    if (string.length() > 100) {
                        packetWrapper.set(Types.STRING, 0, string.substring(0, 100).trim());
                    }
                });
            }
        });
    }

    private int getNewSoundId(int n) {
        if (n == 196) {
            return -1;
        }
        if (n >= 85) {
            n += 2;
        }
        if (n >= 176) {
            ++n;
        }
        if (n >= 197) {
            n += 8;
        }
        if (n >= 207) {
            --n;
        }
        if (n >= 279) {
            n += 9;
        }
        if (n >= 296) {
            ++n;
        }
        if (n >= 390) {
            n += 4;
        }
        if (n >= 400) {
            n += 3;
        }
        if (n >= 450) {
            ++n;
        }
        if (n >= 455) {
            ++n;
        }
        if (n >= 470) {
            ++n;
        }
        return n;
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addEntityTracker(this.getClass(), new EntityTracker1_11(userConnection));
        userConnection.addClientWorld(this.getClass(), new ClientWorld());
    }

    public EntityPacketRewriter1_11 getEntityRewriter() {
        return this.entityRewriter;
    }

    public ItemPacketRewriter1_11 getItemRewriter() {
        return this.itemRewriter;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_13to1_13_1;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_13;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13to1_13_1.rewriter.EntityPacketRewriter1_13_1;
import com.viaversion.viaversion.protocols.v1_13to1_13_1.rewriter.ItemPacketRewriter1_13_1;
import com.viaversion.viaversion.protocols.v1_13to1_13_1.rewriter.WorldPacketRewriter1_13_1;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;

public class Protocol1_13To1_13_1
extends AbstractProtocol<ClientboundPackets1_13, ClientboundPackets1_13, ServerboundPackets1_13, ServerboundPackets1_13> {
    public static final MappingData MAPPINGS = new MappingDataBase("1.13", "1.13.2");
    private final EntityPacketRewriter1_13_1 entityRewriter = new EntityPacketRewriter1_13_1(this);
    private final ItemPacketRewriter1_13_1 itemRewriter = new ItemPacketRewriter1_13_1(this);
    private final ParticleRewriter<ClientboundPackets1_13> particleRewriter = new ParticleRewriter<ClientboundPackets1_13>(this);
    private final TagRewriter<ClientboundPackets1_13> tagRewriter = new TagRewriter<ClientboundPackets1_13>(this);
    private final BlockRewriter<ClientboundPackets1_13> blockRewriter = BlockRewriter.legacy(this);

    public Protocol1_13To1_13_1() {
        super(ClientboundPackets1_13.class, ClientboundPackets1_13.class, ServerboundPackets1_13.class, ServerboundPackets1_13.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        WorldPacketRewriter1_13_1.register(this);
        this.registerServerbound(ServerboundPackets1_13.COMMAND_SUGGESTION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.STRING, new ValueTransformer<String, String>(Types.STRING){

                    @Override
                    public String transform(PacketWrapper packetWrapper, String string) {
                        return string.startsWith("/") ? string.substring(1) : string;
                    }
                });
            }
        });
        this.registerServerbound(ServerboundPackets1_13.EDIT_BOOK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.ITEM1_13);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    Item item = packetWrapper.get(Types.ITEM1_13, 0);
                    Protocol1_13To1_13_1.this.itemRewriter.handleItemToServer(packetWrapper.user(), item);
                });
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    if (n == 1) {
                        packetWrapper.cancel();
                    }
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_13.COMMAND_SUGGESTIONS, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 1);
                    packetWrapper.set(Types.VAR_INT, 1, n + 1);
                    int n2 = packetWrapper.get(Types.VAR_INT, 3);
                    for (int i = 0; i < n2; ++i) {
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.passthrough(Types.OPTIONAL_COMPONENT);
                    }
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_13.BOSS_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UUID);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (n == 0) {
                        packetWrapper.passthrough(Types.COMPONENT);
                        packetWrapper.passthrough(Types.FLOAT);
                        packetWrapper.passthrough(Types.VAR_INT);
                        packetWrapper.passthrough(Types.VAR_INT);
                        short s = packetWrapper.read(Types.BYTE).byteValue();
                        if ((s & 2) != 0) {
                            s = (short)(s | 4);
                        }
                        packetWrapper.write(Types.UNSIGNED_BYTE, s);
                    }
                });
            }
        });
        this.tagRewriter.register(ClientboundPackets1_13.UPDATE_TAGS, RegistryType.ITEM);
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addEntityTracker(this.getClass(), new EntityTrackerBase(userConnection, EntityTypes1_13.EntityType.PLAYER));
        userConnection.addClientWorld(this.getClass(), new ClientWorld());
    }

    @Override
    public MappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_13_1 getEntityRewriter() {
        return this.entityRewriter;
    }

    public ItemPacketRewriter1_13_1 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_13> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_13> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_13> getTagRewriter() {
        return this.tagRewriter;
    }
}


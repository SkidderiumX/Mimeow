/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viarewind.api.data.RewindMappingData;
import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ClientboundPackets1_7_2_5;
import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ServerboundPackets1_7_2_5;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider.CompressionHandlerProvider;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider.compression.TrackingCompressionHandlerProvider;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.rewriter.BlockItemPacketRewriter1_8;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.rewriter.EntityPacketRewriter1_8;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.rewriter.PlayerPacketRewriter1_8;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.rewriter.ScoreboardPacketRewriter1_8;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.rewriter.WorldPacketRewriter1_8;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.CompressionStatusTracker;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.EntityTracker1_8;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.GameProfileStorage;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.InventoryTracker;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.PlayerSessionStorage;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.ScoreboardTracker;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.WorldBorderEmulator;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.task.WorldBorderUpdateTask;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.exception.CancelException;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.ServerboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_8;
import java.util.concurrent.TimeUnit;

public class Protocol1_8To1_7_6_10
extends BackwardsProtocol<ClientboundPackets1_8, ClientboundPackets1_7_2_5, ServerboundPackets1_8, ServerboundPackets1_7_2_5> {
    public static final RewindMappingData MAPPINGS = new RewindMappingData("1.8", "1.7.10");
    private final BlockItemPacketRewriter1_8 itemRewriter = new BlockItemPacketRewriter1_8(this);
    private final EntityPacketRewriter1_8 entityRewriter = new EntityPacketRewriter1_8(this);

    public Protocol1_8To1_7_6_10() {
        super(ClientboundPackets1_8.class, ClientboundPackets1_7_2_5.class, ServerboundPackets1_8.class, ServerboundPackets1_7_2_5.class);
    }

    @Override
    protected void registerPackets() {
        this.itemRewriter.register();
        this.entityRewriter.register();
        new PlayerPacketRewriter1_8(this).register();
        new ScoreboardPacketRewriter1_8(this).register();
        new WorldPacketRewriter1_8(this).register();
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.HELLO, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE_ARRAY_PRIMITIVE, Types.SHORT_BYTE_ARRAY);
                this.map(Types.BYTE_ARRAY_PRIMITIVE, Types.SHORT_BYTE_ARRAY);
            }
        });
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_COMPRESSION, this::handleCompression);
        this.registerClientbound(ClientboundPackets1_8.SET_COMPRESSION, null, this::handleCompression);
        this.registerClientbound(ClientboundPackets1_8.KEEP_ALIVE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
            }
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.ENCRYPTION_KEY, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.SHORT_BYTE_ARRAY, Types.BYTE_ARRAY_PRIMITIVE);
                this.map(Types.SHORT_BYTE_ARRAY, Types.BYTE_ARRAY_PRIMITIVE);
            }
        });
        this.registerServerbound(ServerboundPackets1_7_2_5.KEEP_ALIVE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT, Types.VAR_INT);
            }
        });
    }

    private void handleCompression(PacketWrapper packetWrapper) {
        packetWrapper.cancel();
        int n = packetWrapper.read(Types.VAR_INT);
        Via.getManager().getProviders().get(CompressionHandlerProvider.class).setCompressionThreshold(packetWrapper.user(), n);
    }

    @Override
    public void transform(Direction direction, State state, PacketWrapper packetWrapper) throws CancelException {
        Via.getManager().getProviders().get(CompressionHandlerProvider.class).onTransformPacket(packetWrapper.user());
        super.transform(direction, state, packetWrapper);
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addEntityTracker(this.getClass(), new EntityTracker1_8(userConnection));
        userConnection.addClientWorld(this.getClass(), new ClientWorld());
        userConnection.put(new InventoryTracker(userConnection));
        userConnection.put(new PlayerSessionStorage(userConnection));
        userConnection.put(new GameProfileStorage(userConnection));
        userConnection.put(new ScoreboardTracker(userConnection));
        userConnection.put(new CompressionStatusTracker(userConnection));
        userConnection.put(new WorldBorderEmulator(userConnection));
    }

    @Override
    public void register(ViaProviders viaProviders) {
        viaProviders.register(CompressionHandlerProvider.class, new TrackingCompressionHandlerProvider());
        if (ViaRewind.getConfig().isEmulateWorldBorder()) {
            Via.getManager().getScheduler().scheduleRepeating(new WorldBorderUpdateTask(), 0L, 50L, TimeUnit.MILLISECONDS);
        }
    }

    @Override
    public RewindMappingData getMappingData() {
        return MAPPINGS;
    }

    public BlockItemPacketRewriter1_8 getItemRewriter() {
        return this.itemRewriter;
    }

    public EntityPacketRewriter1_8 getEntityRewriter() {
        return this.entityRewriter;
    }

    @Override
    public boolean hasMappingDataToLoad() {
        return true;
    }
}


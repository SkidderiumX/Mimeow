/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_9to1_8;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viarewind.api.data.RewindMappingData;
import com.viaversion.viarewind.protocol.v1_9to1_8.provider.InventoryProvider;
import com.viaversion.viarewind.protocol.v1_9to1_8.rewriter.BlockItemPacketRewriter1_9;
import com.viaversion.viarewind.protocol.v1_9to1_8.rewriter.EntityPacketRewriter1_9;
import com.viaversion.viarewind.protocol.v1_9to1_8.rewriter.PlayerPacketRewriter1_9;
import com.viaversion.viarewind.protocol.v1_9to1_8.rewriter.WorldPacketRewriter1_9;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.BlockPlaceDestroyTracker;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.BossBarStorage;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.CooldownStorage;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.EntityTracker1_9;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.LevitationStorage;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.PlayerPositionTracker;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.WindowTracker;
import com.viaversion.viarewind.protocol.v1_9to1_8.task.CooldownIndicatorTask;
import com.viaversion.viarewind.protocol.v1_9to1_8.task.LevitationUpdateTask;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_9;
import java.util.concurrent.TimeUnit;

public class Protocol1_9To1_8
extends BackwardsProtocol<ClientboundPackets1_9, ClientboundPackets1_8, ServerboundPackets1_9, ServerboundPackets1_8> {
    public static final ValueTransformer<Double, Integer> DOUBLE_TO_INT_TIMES_32 = new ValueTransformer<Double, Integer>((Type)Types.INT){

        @Override
        public Integer transform(PacketWrapper packetWrapper, Double d) {
            return (int)(d * 32.0);
        }
    };
    public static final ValueTransformer<Float, Byte> DEGREES_TO_ANGLE = new ValueTransformer<Float, Byte>((Type)Types.BYTE){

        @Override
        public Byte transform(PacketWrapper packetWrapper, Float f) {
            return (byte)(f.floatValue() / 360.0f * 256.0f);
        }
    };
    public static final RewindMappingData MAPPINGS = new RewindMappingData("1.9.4", "1.8");
    private final BlockItemPacketRewriter1_9 itemRewriter = new BlockItemPacketRewriter1_9(this);
    private final EntityPacketRewriter1_9 entityRewriter = new EntityPacketRewriter1_9(this);

    public Protocol1_9To1_8() {
        super(ClientboundPackets1_9.class, ClientboundPackets1_8.class, ServerboundPackets1_9.class, ServerboundPackets1_8.class);
    }

    @Override
    protected void registerPackets() {
        this.entityRewriter.register();
        this.itemRewriter.register();
        new PlayerPacketRewriter1_9(this).register();
        new WorldPacketRewriter1_9(this).register();
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addEntityTracker(this.getClass(), new EntityTracker1_9(userConnection));
        userConnection.addClientWorld(this.getClass(), new ClientWorld());
        userConnection.put(new WindowTracker(userConnection));
        userConnection.put(new LevitationStorage());
        userConnection.put(new PlayerPositionTracker());
        userConnection.put(new CooldownStorage());
        userConnection.put(new BlockPlaceDestroyTracker());
        userConnection.put(new BossBarStorage(userConnection));
    }

    @Override
    public void register(ViaProviders viaProviders) {
        viaProviders.register(InventoryProvider.class, new InventoryProvider());
        Via.getManager().getScheduler().scheduleRepeating(new LevitationUpdateTask(), 0L, 50L, TimeUnit.MILLISECONDS);
        Via.getManager().getScheduler().scheduleRepeating(new CooldownIndicatorTask(), 0L, 50L, TimeUnit.MILLISECONDS);
    }

    @Override
    public RewindMappingData getMappingData() {
        return MAPPINGS;
    }

    public BlockItemPacketRewriter1_9 getItemRewriter() {
        return this.itemRewriter;
    }

    public EntityPacketRewriter1_9 getEntityRewriter() {
        return this.entityRewriter;
    }

    @Override
    public boolean hasMappingDataToLoad() {
        return true;
    }
}


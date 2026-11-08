/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.BossBarProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.CommandBlockProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.CompressionProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.EntityIdProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.HandItemProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.MainHandProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.MovementTransmitterProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.rewriter.EntityPacketRewriter1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.rewriter.ItemPacketRewriter1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.rewriter.PlayerPacketRewriter1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.rewriter.SpawnPacketRewriter1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.rewriter.WorldPacketRewriter1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.ClientWorld1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.CommandBlockStorage;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.EntityTracker1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.InventoryTracker;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.MovementTracker;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.SerializerVersion;

public class Protocol1_8To1_9
extends AbstractProtocol<ClientboundPackets1_8, ClientboundPackets1_9, ServerboundPackets1_8, ServerboundPackets1_9> {
    public static final ValueTransformer<String, JsonElement> STRING_TO_JSON = new ValueTransformer<String, JsonElement>(Types.COMPONENT){

        @Override
        public JsonElement transform(PacketWrapper packetWrapper, String string) {
            return ComponentUtil.convertJsonOrEmpty(string, SerializerVersion.V1_8, SerializerVersion.V1_9);
        }
    };
    private final EntityPacketRewriter1_9 entityRewriter = new EntityPacketRewriter1_9(this);
    private final ItemPacketRewriter1_9 itemRewriter = new ItemPacketRewriter1_9(this);

    public Protocol1_8To1_9() {
        super(ClientboundPackets1_8.class, ClientboundPackets1_9.class, ServerboundPackets1_8.class, ServerboundPackets1_9.class);
    }

    public static boolean isSword(int n) {
        switch (n) {
            case 267: 
            case 268: 
            case 272: 
            case 276: 
            case 283: {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_DISCONNECT, (PacketWrapper packetWrapper) -> STRING_TO_JSON.write(packetWrapper, packetWrapper.read(Types.STRING)));
        SpawnPacketRewriter1_9.register(this);
        PlayerPacketRewriter1_9.register(this);
        WorldPacketRewriter1_9.register(this);
    }

    @Override
    public void register(ViaProviders viaProviders) {
        viaProviders.register(HandItemProvider.class, new HandItemProvider());
        viaProviders.register(CommandBlockProvider.class, new CommandBlockProvider());
        viaProviders.register(EntityIdProvider.class, new EntityIdProvider());
        viaProviders.register(BossBarProvider.class, new BossBarProvider());
        viaProviders.register(MainHandProvider.class, new MainHandProvider());
        viaProviders.register(CompressionProvider.class, new CompressionProvider());
        viaProviders.register(MovementTransmitterProvider.class, new MovementTransmitterProvider());
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addEntityTracker(this.getClass(), new EntityTracker1_9(userConnection));
        userConnection.addClientWorld(this.getClass(), new ClientWorld1_9());
        userConnection.put(new MovementTracker());
        userConnection.put(new InventoryTracker());
        userConnection.put(new CommandBlockStorage());
    }

    public EntityPacketRewriter1_9 getEntityRewriter() {
        return this.entityRewriter;
    }

    public ItemPacketRewriter1_9 getItemRewriter() {
        return this.itemRewriter;
    }
}


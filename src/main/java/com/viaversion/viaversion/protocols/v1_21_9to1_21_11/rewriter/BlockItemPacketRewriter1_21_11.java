/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_9to1_21_11.rewriter;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.AttackRange;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPacket1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundPacket1_21_9;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.Protocol1_21_9To1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.storage.GameTimeStorage;
import com.viaversion.viaversion.rewriter.StructuredItemRewriter;

public class BlockItemPacketRewriter1_21_11
extends StructuredItemRewriter<ClientboundPacket1_21_9, ServerboundPacket1_21_9, Protocol1_21_9To1_21_11> {
    public BlockItemPacketRewriter1_21_11(Protocol1_21_9To1_21_11 protocol1_21_9To1_21_11) {
        super(protocol1_21_9To1_21_11);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_9To1_21_11)this.protocol).registerClientbound(ClientboundPackets1_21_9.SET_BORDER_LERP_SIZE, packetWrapper -> {
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.write(Types.VAR_LONG, packetWrapper.read(Types.VAR_LONG) / 50L);
        });
        ((Protocol1_21_9To1_21_11)this.protocol).registerClientbound(ClientboundPackets1_21_9.INITIALIZE_BORDER, packetWrapper -> {
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.write(Types.VAR_LONG, packetWrapper.read(Types.VAR_LONG) / 50L);
        });
        ((Protocol1_21_9To1_21_11)this.protocol).registerClientbound(ClientboundPackets1_21_9.SET_TIME, packetWrapper -> {
            long l = packetWrapper.passthrough(Types.LONG);
            packetWrapper.user().get(GameTimeStorage.class).setGameTime(l);
        });
        ((Protocol1_21_9To1_21_11)this.protocol).registerServerbound(ServerboundPackets1_21_6.CLIENT_TICK_END, packetWrapper -> packetWrapper.user().get(GameTimeStorage.class).incrementGameTime());
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        BlockItemPacketRewriter1_21_11.upgradeData(item, structuredDataContainer);
        this.appendItemDataFixComponents(userConnection, item);
        super.handleItemDataComponentsToClient(userConnection, item, structuredDataContainer);
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        BlockItemPacketRewriter1_21_11.downgradeData(item, structuredDataContainer);
        super.handleItemDataComponentsToServer(userConnection, item, structuredDataContainer);
    }

    private void appendItemDataFixComponents(UserConnection userConnection, Item item) {
        ProtocolVersion protocolVersion = userConnection.getProtocolInfo().serverProtocolVersion();
        if (Via.getConfig().use1_8HitboxMargin() && protocolVersion.olderThanOrEqualTo(ProtocolVersion.v1_8)) {
            item.dataContainer().set(StructuredDataKey.ATTACK_RANGE, new AttackRange(0.0f, 3.0f, 0.0f, 4.0f, 0.1f, 1.0f));
        }
    }

    public static void upgradeData(Item item, StructuredDataContainer structuredDataContainer) {
    }

    public static void downgradeData(Item item, StructuredDataContainer structuredDataContainer) {
        structuredDataContainer.remove(StructuredDataKey.SWING_ANIMATION);
        structuredDataContainer.remove(StructuredDataKey.KINETIC_WEAPON);
        structuredDataContainer.remove(StructuredDataKey.PIERCING_WEAPON);
        structuredDataContainer.remove(StructuredDataKey.DAMAGE_TYPE1_21_11);
        structuredDataContainer.remove(StructuredDataKey.MINIMUM_ATTACK_CHARGE);
        structuredDataContainer.remove(StructuredDataKey.USE_EFFECTS);
        structuredDataContainer.remove(StructuredDataKey.ZOMBIE_NAUTILUS_VARIANT1_21_11);
        structuredDataContainer.remove(StructuredDataKey.ATTACK_RANGE);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_2to1_21_4.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.Consumable1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.CustomModelData1_21_4;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.Protocol1_21_2To1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPacket1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPackets1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.provider.PickItemProvider;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.StructuredItemRewriter;

public class BlockItemPacketRewriter1_21_4
extends StructuredItemRewriter<ClientboundPacket1_21_2, ServerboundPacket1_21_4, Protocol1_21_2To1_21_4> {
    public BlockItemPacketRewriter1_21_4(Protocol1_21_2To1_21_4 protocol1_21_2To1_21_4) {
        super(protocol1_21_2To1_21_4);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_2To1_21_4)this.protocol).registerClientbound(ClientboundPackets1_21_2.SET_HELD_SLOT, packetWrapper -> {
            byte by = packetWrapper.read(Types.BYTE);
            packetWrapper.write(Types.VAR_INT, Integer.valueOf(by));
        });
        ((Protocol1_21_2To1_21_4)this.protocol).registerServerbound(ServerboundPackets1_21_4.PICK_ITEM_FROM_BLOCK, null, packetWrapper -> {
            BlockPosition blockPosition = packetWrapper.read(Types.BLOCK_POSITION1_14);
            boolean bl = packetWrapper.read(Types.BOOLEAN);
            Via.getManager().getProviders().get(PickItemProvider.class).pickItemFromBlock(packetWrapper.user(), blockPosition, bl);
            packetWrapper.cancel();
        });
        ((Protocol1_21_2To1_21_4)this.protocol).registerServerbound(ServerboundPackets1_21_4.PICK_ITEM_FROM_ENTITY, null, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            boolean bl = packetWrapper.read(Types.BOOLEAN);
            Via.getManager().getProviders().get(PickItemProvider.class).pickItemFromEntity(packetWrapper.user(), n, bl);
            packetWrapper.cancel();
        });
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        super.handleItemToClient(userConnection, item);
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        Integer n = structuredDataContainer.get(StructuredDataKey.CUSTOM_MODEL_DATA1_20_5);
        if (n != null) {
            structuredDataContainer.set(StructuredDataKey.CUSTOM_MODEL_DATA1_21_4, new CustomModelData1_21_4(new float[]{n.floatValue()}, new boolean[0], new String[0], new int[0]));
            this.saveTag(this.createCustomTag(item), new IntTag(n), "custom_model_data");
        }
        BlockItemPacketRewriter1_21_4.updateItemData(item);
        this.appendItemDataFixComponents(userConnection, item);
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        Tag tag;
        super.handleItemToServer(userConnection, item);
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        CompoundTag compoundTag = structuredDataContainer.get(StructuredDataKey.CUSTOM_DATA);
        if (compoundTag != null && (tag = compoundTag.remove(this.nbtTagName("custom_model_data"))) instanceof IntTag) {
            IntTag intTag = (IntTag)tag;
            structuredDataContainer.set(StructuredDataKey.CUSTOM_MODEL_DATA1_20_5, intTag.asInt());
            this.removeCustomTag(structuredDataContainer, compoundTag);
        }
        BlockItemPacketRewriter1_21_4.downgradeItemData(item);
        return item;
    }

    private void appendItemDataFixComponents(UserConnection userConnection, Item item) {
        ProtocolVersion protocolVersion = userConnection.getProtocolInfo().serverProtocolVersion();
        if (protocolVersion.olderThanOrEqualTo(ProtocolVersion.v1_8) && (item.identifier() == 849 || item.identifier() == 854 || item.identifier() == 859 || item.identifier() == 864 || item.identifier() == 869)) {
            item.dataContainer().set(StructuredDataKey.CONSUMABLE1_21_2, new Consumable1_21_2(3600.0f, 3, Holder.of(new SoundEvent("minecraft:intentionally_empty", null)), false, new Consumable1_21_2.ConsumeEffect[0]));
        }
    }

    public static void updateItemData(Item item) {
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        structuredDataContainer.replaceKey(StructuredDataKey.TRIM1_21_2, StructuredDataKey.TRIM1_21_4);
        structuredDataContainer.remove(StructuredDataKey.CUSTOM_MODEL_DATA1_20_5);
    }

    public static void downgradeItemData(Item item) {
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        structuredDataContainer.replaceKey(StructuredDataKey.TRIM1_21_4, StructuredDataKey.TRIM1_21_2);
        structuredDataContainer.remove(StructuredDataKey.CUSTOM_MODEL_DATA1_21_4);
    }
}


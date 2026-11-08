/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_7to1_21_9.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ResolvableProfile;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_9;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.Bee;
import com.viaversion.viaversion.api.minecraft.item.data.BlockEntityData;
import com.viaversion.viaversion.api.minecraft.item.data.EntityData;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.Protocol1_21_7To1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundPacket1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.storage.DimensionScaleStorage;
import com.viaversion.viaversion.rewriter.StructuredItemRewriter;

public class BlockItemPacketRewriter1_21_9
extends StructuredItemRewriter<ClientboundPacket1_21_6, ServerboundPacket1_21_9, Protocol1_21_7To1_21_9> {
    public BlockItemPacketRewriter1_21_9(Protocol1_21_7To1_21_9 protocol1_21_7To1_21_9) {
        super(protocol1_21_7To1_21_9);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_7To1_21_9)this.protocol).registerClientbound(ClientboundPackets1_21_6.INITIALIZE_BORDER, this::updateBorderCenter);
        ((Protocol1_21_7To1_21_9)this.protocol).registerClientbound(ClientboundPackets1_21_6.SET_BORDER_CENTER, this::updateBorderCenter);
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        BlockItemPacketRewriter1_21_9.upgradeData(item, structuredDataContainer);
        super.handleItemDataComponentsToClient(userConnection, item, structuredDataContainer);
    }

    public static void upgradeData(Item item, StructuredDataContainer structuredDataContainer) {
        structuredDataContainer.replace(StructuredDataKey.BEES1_20_5, StructuredDataKey.BEES1_21_9, beeArray -> {
            for (int i = 0; i < ((Bee[])beeArray).length; ++i) {
                Bee bee = beeArray[i];
                beeArray[i] = new Bee(new EntityData(EntityTypes1_21_9.BEE.getId(), bee.entityData().tag()), bee.ticksInHive(), bee.minTicksInHive());
            }
            return beeArray;
        });
        structuredDataContainer.replace(StructuredDataKey.ENTITY_DATA1_20_5, StructuredDataKey.ENTITY_DATA1_21_9, compoundTag -> {
            int n = Protocol1_21_7To1_21_9.MAPPINGS.getEntityMappings().mappedId(compoundTag.getString("id", "pig"));
            return new EntityData(n == -1 ? 0 : n, (CompoundTag)compoundTag);
        });
        structuredDataContainer.replace(StructuredDataKey.BLOCK_ENTITY_DATA1_20_5, StructuredDataKey.BLOCK_ENTITY_DATA1_21_9, compoundTag -> {
            int n = Protocol1_21_7To1_21_9.MAPPINGS.getBlockEntityMappings().mappedId(compoundTag.getString("id", "furnace"));
            return new BlockEntityData(n == -1 ? 0 : n, (CompoundTag)compoundTag);
        });
        structuredDataContainer.replace(StructuredDataKey.PROFILE1_20_5, StructuredDataKey.PROFILE1_21_9, ResolvableProfile::new);
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        BlockItemPacketRewriter1_21_9.downgradeData(item, structuredDataContainer);
        super.handleItemDataComponentsToServer(userConnection, item, structuredDataContainer);
    }

    public static void downgradeData(Item item, StructuredDataContainer structuredDataContainer) {
        structuredDataContainer.replaceKey(StructuredDataKey.BEES1_21_9, StructuredDataKey.BEES1_20_5);
        structuredDataContainer.replace(StructuredDataKey.ENTITY_DATA1_21_9, StructuredDataKey.ENTITY_DATA1_20_5, entityData -> {
            String string = Protocol1_21_7To1_21_9.MAPPINGS.getEntityMappings().identifier(entityData.type());
            entityData.tag().putString("id", string);
            return entityData.tag();
        });
        structuredDataContainer.replace(StructuredDataKey.BLOCK_ENTITY_DATA1_21_9, StructuredDataKey.BLOCK_ENTITY_DATA1_20_5, blockEntityData -> {
            String string = Protocol1_21_7To1_21_9.MAPPINGS.getBlockEntityMappings().identifier(blockEntityData.type());
            blockEntityData.tag().putString("id", string);
            return blockEntityData.tag();
        });
        structuredDataContainer.replace(StructuredDataKey.PROFILE1_21_9, StructuredDataKey.PROFILE1_20_5, ResolvableProfile::profile);
    }

    private void updateBorderCenter(PacketWrapper packetWrapper) {
        double d = packetWrapper.read(Types.DOUBLE);
        double d2 = packetWrapper.read(Types.DOUBLE);
        Object e = ((Protocol1_21_7To1_21_9)this.protocol).getEntityRewriter().tracker(packetWrapper.user());
        if (e.currentDimensionId() != -1) {
            double d3 = packetWrapper.user().get(DimensionScaleStorage.class).getScale(e.currentDimensionId());
            d /= d3;
            d2 /= d3;
        }
        packetWrapper.write(Types.DOUBLE, d);
        packetWrapper.write(Types.DOUBLE, d2);
    }
}

